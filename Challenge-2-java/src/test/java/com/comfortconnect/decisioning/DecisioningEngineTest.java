package com.comfortconnect.decisioning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test cases for the DecisioningEngine.
 *
 * Run these manually or with JUnit. All should pass when implementation is complete.
 * You can add more tests if time permits.
 */
public class DecisioningEngineTest {

    private static final List<PartnerRule> RULES = Arrays.asList(
        new PartnerRule("premier", "Premier Program", 680, 50000,
            Arrays.asList("HVAC", "Plumbing", "Generator"), Collections.emptyList(),
            5.99, 60, "0% for first 12 months"),
        new PartnerRule("partner1", "Partner 1 Finance", 600, 30000,
            Arrays.asList("HVAC", "Plumbing"), Arrays.asList("CA", "NY"),
            7.49, 48, null),
        new PartnerRule("partner2", "Partner 2 Leasing", 550, 25000,
            Collections.singletonList("Solar"), Collections.emptyList(),
            9.99, 36, "No credit check required"),
        new PartnerRule("partner3", "Partner 3 Financial", 650, 40000,
            Arrays.asList("HVAC", "Plumbing", "Generator", "Solar"), Collections.singletonList("FL"),
            6.49, 72, "First payment deferred 90 days"),
        new PartnerRule("partner4", "Partner 4 Energy Finance", 700, 60000,
            Arrays.asList("HVAC", "Solar", "Generator"), Collections.emptyList(),
            4.99, 60, "Energy efficiency bonus")
    );

    public static void main(String[] args) {
        DecisioningEngineTest test = new DecisioningEngineTest();
        int passed = 0;
        int failed = 0;

        String[] tests = {
            "testGoodCreditHVAC",
            "testLowCreditNoOffers",
            "testSolarOnlyPartner2",
            "testExcludedState",
            "testLoanAmountExceedsMax",
            "testNullApplicationThrows",
            "testOffersRankedByApr"
        };

        for (String testName : tests) {
            try {
                switch (testName) {
                    case "testGoodCreditHVAC": test.testGoodCreditHVAC(); break;
                    case "testLowCreditNoOffers": test.testLowCreditNoOffers(); break;
                    case "testSolarOnlyPartner2": test.testSolarOnlyPartner2(); break;
                    case "testExcludedState": test.testExcludedState(); break;
                    case "testLoanAmountExceedsMax": test.testLoanAmountExceedsMax(); break;
                    case "testNullApplicationThrows": test.testNullApplicationThrows(); break;
                    case "testOffersRankedByApr": test.testOffersRankedByApr(); break;
                }
                System.out.println("PASS: " + testName);
                passed++;
            } catch (Exception e) {
                System.out.println("FAIL: " + testName + " — " + e.getMessage());
                failed++;
            }
        }

        System.out.println("\nResults: " + passed + " passed, " + failed + " failed out of " + (passed + failed));
    }

    /**
     * Credit score 720, HVAC, $15k loan, MD
     * Expected: 4 offers (partner4, Premier, partner3, partner1) — NOT partner2 (Solar only)
     */
    public void testGoodCreditHVAC() {
        DecisioningEngine engine = new DecisioningEngine(RULES);
        Application app = new Application("APP-001", 720, 15000.0, "HVAC", "MD");
        List<Offer> offers = engine.evaluate(app);

        assertEquals("Should return 4 offers", 4, offers.size());
        assertEquals("First offer should be partner4 (lowest APR)", "partner4", offers.get(0).getPartnerId());
        assertEquals("Second offer should be Premier", "premier", offers.get(1).getPartnerId());
    }

    /**
     * Credit score 580 — below all partner minimums
     * Expected: empty list
     */
    public void testLowCreditNoOffers() {
        DecisioningEngine engine = new DecisioningEngine(RULES);
        Application app = new Application("APP-002", 580, 8000.0, "Plumbing", "TX");
        List<Offer> offers = engine.evaluate(app);

        assertEquals("Should return 0 offers for low credit", 0, offers.size());
    }

    /**
     * Solar equipment, credit 560
     * Expected: only partner2 (Solar support, min credit 550)
     */
    public void testSolarOnlyPartner2() {
        DecisioningEngine engine = new DecisioningEngine(RULES);
        Application app = new Application("APP-003", 560, 10000.0, "Solar", "MD");
        List<Offer> offers = engine.evaluate(app);

        assertEquals("Should return 1 offer", 1, offers.size());
        assertEquals("Should be partner2", "partner2", offers.get(0).getPartnerId());
    }

    /**
     * Applicant in California — partner1 excludes CA
     * Credit 620, HVAC, should get partner1 normally but not due to state exclusion
     */
    public void testExcludedState() {
        DecisioningEngine engine = new DecisioningEngine(RULES);
        Application app = new Application("APP-004", 620, 15000.0, "HVAC", "CA");
        List<Offer> offers = engine.evaluate(app);

        for (Offer offer : offers) {
            if ("partner1".equals(offer.getPartnerId())) {
                throw new AssertionError("partner1 should be excluded for CA applicants");
            }
        }
    }

    /**
     * Loan amount $55k — exceeds most partners' max except partner4 ($60k)
     * Credit 720, HVAC
     */
    public void testLoanAmountExceedsMax() {
        DecisioningEngine engine = new DecisioningEngine(RULES);
        Application app = new Application("APP-005", 720, 55000.0, "HVAC", "MD");
        List<Offer> offers = engine.evaluate(app);

        assertEquals("Only partner4 should accept $55k loan", 1, offers.size());
        assertEquals("Should be partner4", "partner4", offers.get(0).getPartnerId());
    }

    /**
     * Null application should throw IllegalArgumentException
     */
    public void testNullApplicationThrows() {
        DecisioningEngine engine = new DecisioningEngine(RULES);
        try {
            engine.evaluate(null);
            throw new AssertionError("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Verify offers are ranked by APR ascending
     */
    public void testOffersRankedByApr() {
        DecisioningEngine engine = new DecisioningEngine(RULES);
        Application app = new Application("APP-006", 750, 20000.0, "HVAC", "MD");
        List<Offer> offers = engine.evaluate(app);

        for (int i = 1; i < offers.size(); i++) {
            if (offers.get(i).getApr() < offers.get(i - 1).getApr()) {
                throw new AssertionError("Offers not sorted by APR: " +
                    offers.get(i - 1).getApr() + " should be <= " + offers.get(i).getApr());
            }
        }
    }

    // --- Helper ---
    private static void assertEquals(String message, Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " — expected: " + expected + ", got: " + actual);
        }
    }
}
