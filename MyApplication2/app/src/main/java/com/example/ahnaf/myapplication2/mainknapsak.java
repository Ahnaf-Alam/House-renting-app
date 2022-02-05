package com.example.ahnaf.myapplication2;

/**
 * Created by Ahnaf on 1/23/2019.
 */
public class mainknapsak {
    public void solve(int[] wt, int[] val, int W, int N)

    {
        int n;
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;

        int[][] m = new int[N + 1][W + 1];

        int[][] sol = new int[N + 1][W + 1];



        for (int i = 1; i <= N; i++)

        {

            for (int j = 0; j <= W; j++)

            {

                int m1 = m[i - 1][j];

                int m2 = NEGATIVE_INFINITY;

                if (j >= wt[i])

                    m2 = m[i - 1][j - wt[i]] + val[i];

                /** select max of m1, m2 **/

                m[i][j] = Math.max(m1, m2);

                sol[i][j] = m2 > m1 ? 1 : 0;

            }

        }

        /** make list of what all items to finally select **/

        int[] selected = new int[N + 1];

        for (int i = N, w = W; i > 0; i--)

        {

            if (sol[i][w] != 0)

            {

                selected[i] = 1;

                w = w - wt[i];

            }

            else

                selected[i] = 0;

        }

        /** Print finally selected items **/

        System.out.println("\nItems selected : ");

        for (int i = 1; i < N + 1; i++)

            if (selected[i] == 1)

                System.out.print(i +" ");

        System.out.println();

    }

    /** Main function **/

    public static void main (String[] args)

    {

       // Scanner scan = new Scanner(System.in);

        System.out.println("Knapsack Algorithm Test\n");

        /** Make an object of Knapsack class **/

        //Knapsack ks = new Knapsack();



        System.out.println("Enter number of elements ");

        //int n = scan.nextInt();



        //nt[] wt = new int[];

       // int[] val = new int[];



        //System.out.println("\nEnter weight for "+ n+" elements");

      // for (int i = 1; i <= n; i++)

           // wt[i] = scan.nextInt();

        //System.out.println("\nEnter value for "+ n +" elements");

       // for (int i = 1; i <= n; i++)

           // val[i] = scan.nextInt();



        System.out.println("\nEnter knapsack weight ");

       // int W = scan.nextInt();



       // ks.solve(wt, val, W, n);

    }

}

