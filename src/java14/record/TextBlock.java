package java14.record;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Text Block
 *  key points :
 *      1. TextBlock allows easier embedding javascript, json, html and sql ect... into java code
 *      2. no more string concatenation and escaping is required with the text block.
 *      3. all you need is triple double quote and type away the language your heart desires
 */
public class TextBlock {
    public static void main(String... args) throws ScriptException {
        TextBlock tb = new TextBlock();
        tb.javascriptTextBlockDemo();
        tb.htmlTextBlockDemo();
        tb.sqlTextBlockDemo();
    }

    protected void javascriptTextBlockDemo() throws ScriptException {
        System.out.println("javascript text block example");
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        System.out.println("one dimensional string literal");
        engine.eval("function hello() {\n" +
                "    print('\"Hello, world\"');\n" +
                "}\n" +
                "\n" +
                "hello();\n");

        System.out.println("two dimensional string literal");
        engine.eval("""
                function hello(){
                    print('"Hello world"')
                }
                
                hello();
                """);
    }

    protected void htmlTextBlockDemo() {
        System.out.println("html text block example");
        System.out.println("one dimensional string literal");
        String html = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";
        System.out.println(html);
        System.out.println("two dimensional string literal");
        html = """
                <html>
                    <body>
                        <p>Hello world</p>
                    </body>
                </html>
                """;
        System.out.println(html);

    }

    protected void sqlTextBlockDemo() {
        System.out.println("sql text block example");
        System.out.println("one dimensional string literal");
        String query = "SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`\n" +
                "WHERE `CITY` = 'INDIANAPOLIS'\n" +
                "ORDER BY `EMP_ID`, `LAST_NAME`;\n";

        System.out.println(query);
        System.out.println("two dimensional string literal");
        query = """
               SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
               WHERE CITY = 'INDIANAPOLIS'
               ORDER BY `EMP_ID`, `LAST_NAME`;
                """;
        System.out.println(query);

    }
}
