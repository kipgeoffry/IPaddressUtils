package net.kigen;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

       final String CIDR4IP = ".0.0.0/1";
        // an IPv4 address
//        final String INET4ADDRESS = "172.12.1.1";

        //Validate CIDR
        if (ValidateIP.isValidCidrAddress(CIDR4IP)){
            System.out.print("The IP address " + CIDR4IP + " is valid");
        }
        else {
            System.out.print("The IP address " + CIDR4IP + " is invalid");
        }


        // Validate an IPv4 address
//        if (ValidateIP.isValidInet4Address(INET4ADDRESS)){
//            System.out.print("The IP address " + INET4ADDRESS + " is valid");
//        }
//        else {
//            System.out.print("The IP address " + INET4ADDRESS + " isn't valid");
//        }

//        SubnetUtils utils = new SubnetUtils(subnet);
//        try {
//            String netmask = utils.getInfo().getNetmask();
//            String address = null;
//            if (netmask.equals("255.255.255.252")){
//                address = utils.getInfo().getHighAddress();
//            } else if (netmask.equals("255.255.255.254")) {
//                address = utils.getInfo().getBroadcastAddress();
//            }else {
//                System.out.println(netmask);
//                address = utils.getInfo().getAddress();
//            }
//            System.out.println(address);
//        } catch(IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }
}