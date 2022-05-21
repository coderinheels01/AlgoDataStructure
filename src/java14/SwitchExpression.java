package java14;

import java.util.Locale;

/**
 * Switch Expression ( new in java 14 )
 * key points :
 *  1. Switch expression returns a value. Old switch statements can't return a value unless it implicitly assigns a value to a variable
 *  2. Switch expression can be either simple statement with " : " and yield or it could be an arrow function
 *  3. It is yield instead of a return because we are returning from a block not from the arrow function and it would be confusing otherwise
 *  4. We no longer have to use break;
 *  5. Newer IntelliJ will be shipped with java 14 built in
 *  6. We can stack multiple cases stacked together and return a value ( look at example 3 below)
 *  7. This was a preview feature in java 12 but now it is finally out of preview in java 14
 *  8. mixing old and new syntax is possible but it's best to avoid it
 */
public class SwitchExpression {

    public static void main(String... args){
        String language = "french";
        SwitchExpression swe = new SwitchExpression();
        swe.switchExpressionWithYield(language);
        swe.switchExpressionWithArrowFunction(language);
        swe.switchExpressionWithArrowFunctionWithMultipleCases("canadian");
    }

    public void switchExpressionWithYield(String language){
        Locale locale = switch(language) {
            case "french": yield Locale.FRENCH;
            case "italy": yield Locale.ITALY;
            default : yield Locale.ENGLISH;
        };
        System.out.println(locale);
    }
    public void switchExpressionWithArrowFunction(String language){
        Locale locale = switch(language) {
            case "french" ->  Locale.FRENCH;
            case "italy" ->  Locale.ITALY;
            default -> Locale.ENGLISH;
        };
        System.out.println(locale);
    }

    public void switchExpressionWithArrowFunctionWithMultipleCases(String language){
        Locale locale = switch(language) {
            case "french" ->  Locale.FRENCH;
            case "italy" ->  Locale.ITALY;
            case "canadian", "british", "australian" ->  Locale.UK;
            default -> Locale.ENGLISH;
        };
        System.out.println(locale);
    }
}
