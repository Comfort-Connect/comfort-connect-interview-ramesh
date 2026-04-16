# Challenge 3: Partner Decisioning Engine

## Context

When a homeowner applies for financing, Comfort Connect evaluates the application against multiple lending partner rule sets and returns ranked, eligible offers. Each partner has different eligibility criteria (min credit score, max loan amount, supported equipment types) and different pricing (base rate, term options, promotional adjustments).

Partner rules change frequently (monthly rate sheet updates, new promos, new partners onboarded). The engine must be config-driven, not hardcoded.

## Task

Implement a `DecisioningEngine` class that:

1. **Accepts a pre-built list of partner rules** (`List<PartnerRule>`) via its constructor — the test file builds the rule set directly in code; no JSON parsing required
2. **Evaluates an application** against all partner rules
3. **Returns eligible offers** ranked by lowest APR, then lowest monthly payment as tiebreaker
4. **Calculates monthly payment** using standard amortization: `P * [r(1+r)^n] / [(1+r)^n - 1]` where P = principal, r = monthly rate, n = term months
5. **Handles edge cases**: no eligible partners, invalid input, partner rule with missing fields

## Classes to Implement

### `DecisioningEngine.java`
```java
public class DecisioningEngine {
    // Accept a pre-built list of partner rules
    public DecisioningEngine(List<PartnerRule> partnerRules);

    // Evaluate application and return ranked offers
    public List<Offer> evaluate(Application application);
}
```

### `Application.java` (data class)
```java
public class Application {
    private String applicationId;
    private int creditScore;
    private double loanAmount;
    private String equipmentType; // "HVAC", "Plumbing", "Generator", "Solar"
    private String state;         // US state abbreviation
}
```

### `Offer.java` (data class)
```java
public class Offer {
    private String partnerId;
    private String partnerName;
    private double apr;
    private int termMonths;
    private double monthlyPayment;
    private double totalCost;
    private String promoLabel;    // null if no promo applies
}
```

## Expected Behavior

```java
Application app = new Application("APP-001", 720, 15000.0, "HVAC", "MD");
List<Offer> offers = engine.evaluate(app);

// Should return offers from eligible partners, sorted by APR:
// 1. Partner1 (4.99%, 60mo, $283.07/mo) — HVAC eligible, credit >= 700
// 2. Premier (5.99%, 60mo, $289.99/mo) — HVAC eligible, credit >= 680
// 3. Partner2 (6.49%, 72mo, $252.39/mo) — HVAC eligible, credit >= 650
// 4. Partner3 (7.49%, 48mo, $362.69/mo) — HVAC eligible, credit >= 600
// NOT: Partner4 — only supports Solar equipment

Application lowCredit = new Application("APP-002", 580, 8000.0, "Plumbing", "TX");
List<Offer> offers2 = engine.evaluate(lowCredit);
// Should return empty list — no partners accept credit < 600
```

## Provided Files

- Starter class files in `src/main/java/com/comfortconnect/decisioning/` (including `PartnerRule.java`)
- Test file in `src/test/java/com/comfortconnect/decisioning/DecisioningEngineTest.java` — builds the partner rule list in code and passes it into the engine

## Running

No external libraries required — plain JDK only.

```bash
cd Challenge-2-java
javac -d out src/main/java/com/comfortconnect/decisioning/*.java src/test/java/com/comfortconnect/decisioning/*.java
java -cp out com.comfortconnect.decisioning.DecisioningEngineTest
```

## Evaluation Criteria

- Correct eligibility filtering
- Accurate monthly payment calculation
- Proper ranking
- Clean separation of concerns
- Error handling for bad input / malformed rules
- The provided test cases should pass
