package net.kigen;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidateIP {
            private static final String IPV4_REGEX =
                "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";

            private static final String CIDR_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,2})$";


        public static boolean isValidInet4Address(String ip)
        {
            Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);
            if (ip == null) {
                System.out.println("IP cannot be null");
                return false;
            }

            if (!IPv4_PATTERN.matcher(ip).matches()) {
                System.out.println("IP does not match pattern");
                return false;

            }

            String[] parts = ip.split("\\.");
            //parts [172, 18, 12, 1]

            // verify that each of the four subgroups of IPv4 addresses is legal
            try {
                for (String segment: parts)
                {
                    // x.0.x.x is accepted but x.01.x.x is not
                    if (Integer.parseInt(segment) > 255 ||
                            (segment.length() > 1 && segment.startsWith("0"))) {
                        System.out.println("An Octet is greater than 255 or starts with 0");
                        return false;
                    }
                }
            } catch (NumberFormatException e) {
                return false;
            }

            return true;
        }

        //validate cidr
    public static boolean isValidCidrAddress(String cidrIp){

        Pattern CIDR_PATTERN = Pattern.compile(CIDR_REGEX);
        if (cidrIp == null) {
            System.out.println("cidrIp cannot be null");
            return false;
        }

        if (!CIDR_PATTERN.matcher(cidrIp).matches()) {
            System.out.println("cidrIP does not match pattern");
            return false;
        }
        String breakdown = cidrIp.replace(".", "/");
        String[] parts = breakdown.split("/");

        // verify that each of the four subgroups of IPv4 addresses is legal
        try {
            for (String segment : parts) {

                // x.0.x.x is accepted but x.01.x.x is not
                if (Integer.parseInt(segment) > 255 ||
                        (segment.length() > 1 && segment.startsWith("0"))) {
                    System.out.println("An Octet is greater than 255 or starts with 0");
                    return false;
                }
            }
            int subnet = Integer.parseInt(parts[4]);
            if(subnet > 32 || subnet < 1){
                //accept default route as valid
                if(subnet == 0 & cidrIp.equals("0.0.0.0/0"))return true;
                System.out.println("Invalid subnet");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;

    }

}






