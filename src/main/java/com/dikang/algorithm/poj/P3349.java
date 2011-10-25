package com.dikang.algorithm.poj;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node
{
    int index;
    Node next;
}

public class P3349
{
    static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    final int N=9997;

    int [][]snow=new int[100010][6];
    boolean check(int s1,int  s2)
    {
        boolean flag;
        int temp;

        for(int j=0;j<6;j++)
        {
            flag=true;
            for(int step=0;step<6;step++)
            {
                if(snow[s1][(j+step)%6]!=snow[s2][step])
                {    flag=false;    break;    }
            }
            if(flag) return true;
        }

        for(int j=0;j<6;j++)
        {
            flag=true;
            for(int step=0;step<6;step++)
            {
                temp=j-step;
                if(temp<0) temp+=6;
                if(snow[s1][temp]!=snow[s2][step])
                {    flag=false;    break;    }
            }
            if(flag) return true;
        }
        return false;
    }
    boolean solve() throws IOException
    {
        int num,sum;
        String input;
        StringTokenizer st;
        num=Integer.parseInt(cin.readLine());

        Node[]vs=new Node[N];
        for(int i=1;i<=num;i++)
        {
            sum=0;
            input=cin.readLine();
            st=new StringTokenizer(input);
            for(int j=0;j<6;j++)
            {
                snow[i][j]=Integer.parseInt(st.nextToken());
                sum+=snow[i][j];
            }
            if(vs[sum%N]==null)        //添加链表
            {
                Node node=new Node();
                node.index=i;
                node.next=null;
                vs[sum%N]=node;
            }
            else
            {
                Node node=new Node();
                node.index=i;
                node.next=vs[sum%N];
                vs[sum%N]=node;
            }
        }
        for(int i=0;i<N;i++)
        {
            for(Node n1=vs[i]; n1!=null; n1=n1.next)
                for(Node n2=n1.next; n2!=null; n2=n2.next)
                    if(check( n1.index , n2.index ))    return true;
        }
        return false;
    }

    public static void main(String args []) throws IOException
    {
        P3349 test=new P3349();
        if(test.solve())
            System.out.println("Twin snowflakes found.");
        else
            System.out.println("No two snowflakes are alike.");
    }
}