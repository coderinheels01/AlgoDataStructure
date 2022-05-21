package java14;

import java.math.BigDecimal;

/**
 * Pattern Matching
 * key points :
 *    1. no longer need to do instanceof some type then type cast it.
 *       for example:
 *            if(object instanceof BigDecimal){
 *                BigDecimal b = (BigDecimal) object;
 *                return b.precision/
 *            }
 *
 *      Instead we can do this now:
 *            if(object instanceof BigDecimal b )
 *                return b.precision();
 *
 */
public class PatternMatching {
    public static void main(String... args){
        PatternMatching pm = new PatternMatching();
        int precision = pm.patternMatchBigDecimal(new BigDecimal(1000000));
        System.out.println(precision);
    }
    protected int patternMatchBigDecimal(Object object){
        if(object instanceof BigDecimal b)
            return b.precision();
        return -1;
    }
}
