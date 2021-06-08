package com.real.zscalar;

public class FindCustomers {
    /**
     * Tables:
     * Account (acno, balance)
     * Customer (cust-names, ssn, street, city)
     * CustAcct (ssn, acno, date)
     * Deposit (branch-name, acno, cust-name, amount, date)
     * Branch (branch-name, street, city)
     * CustomerAccountBranch (ssn, acno, branch-name)
     *
     * Find all customers (name is fine) who have made a deposit at ALL the branches located in city of Atlanta
     */


    /**
     * Solution 1:
     *  1) Find number of unique branches for Atlanta, let it be B;
     *  2) Search deposit table find customers whose aggregated unique branch name is B;
     */


    /**
     * Solution 2:
     *  1) List out all unique branches in Atlanta;
     *  2) Loop through each branch, find unique customers who deposit into this branch;
     *  3) Intersect all results together;
     */
}
