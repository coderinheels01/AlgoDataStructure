package algorithm;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    /*
     * 1. loop through each email
     * 2. find the index of @ symbol and cut the string into two parts one for local name and one for the domain name
     * 3. find the index of + symbol and cut the local name string up to that point because we are discarding everything after +
     * 4. replace all '.' inside the local name string
     * 5. add local name and domain name to the hash set.
     * 6. return the count
     *
     * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     * Output: 2
     * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
     *
     * https://leetcode.com/problems/unique-email-addresses/
     *
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        String domainName;
        String localName;

        for(int i=0; i< emails.length; i++){
            int indexOfDomainName = emails[i].indexOf('@');
            domainName = emails[i].substring(indexOfDomainName);
            localName = emails[i].substring(0, indexOfDomainName);

            if(localName.contains("+")){
                int indexOfPlus = localName.indexOf('+');
                localName = localName.substring(0, indexOfPlus);
            }

            localName = localName.replaceAll("\\.", "");

            uniqueEmails.add(localName+domainName);
        }

        return uniqueEmails.size();
    };

    public static void main(String ...args){
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println("total unique emails : " + numUniqueEmails(emails));
    }
}
