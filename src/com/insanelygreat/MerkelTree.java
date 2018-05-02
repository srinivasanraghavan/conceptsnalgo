package com.insanelygreat;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.List;


class TestMerekel {

    MerkelNode merkelNode;

    static class MerkelNode {

        String data;

        private byte[] digest;

        MerkelNode left;

        MerkelNode right;

        MerkelNode parent;

        public MerkelNode(String data, byte[] digest, MerkelNode parent) {
            this.data = data;
            this.digest = digest;
            this.parent = parent;
        }
    }

    /**
     * @param transcations
     */
    public static void createTree(List<String> transcations) {

        Deque<String> deque = new ArrayDeque<>(transcations);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        while (!deque.isEmpty()) {
            String left = deque.poll();
            String right = null;
            if (!deque.isEmpty()) {
                right = deque.poll();
            }
            md.reset();
            md.update(left.getBytes());
            byte[] leftDigest = md.digest();
            byte[] rightDigest = null;
            if (Objects.nonNull(right)) {
                md.reset();
                md.update(right.getBytes());
                rightDigest = md.digest();
            }
            byte[] parentDigest = null;
            if (Objects.nonNull(rightDigest)) {
                md.reset();
                // Figure out
                //md.update(leftDigest+rightDigest);
                parentDigest = md.digest();
            } else {
                md.update(rightDigest);
                parentDigest = md.digest();
            }

            MerkelNode parentNode = new MerkelNode(null, parentDigest, null);

            MerkelNode leftNode = new MerkelNode(left, leftDigest, parentNode);
            //parentNode.
            if (Objects.nonNull(rightDigest)) {
                MerkelNode rightNode = new MerkelNode(right, rightDigest, parentNode);
            }

            System.out.println("Message digest object info: ");
            System.out.println("   Algorithm = " + md.getAlgorithm());
            System.out.println("   Provider = " + md.getProvider());
            System.out.println("   toString = " + md.toString());


        }
    }

}


/**
 * Created by abhilashk.cse@gmail.com on 20-06-2016.
 * Simple implementation of Merkle Tree in Java using Generics
 */

public class MerkelTree<T> {

    private List<T> seed;
    private List<T> hash;

    public MerkelTree(List<T> seed) {
        this.seed = seed;
    }

    public T buildTree() {
        this.hash = getHashed(seed);

        while (hash.size() != 1) {
            hash = getHashed(hash);
        }
        return hash.get(0);
    }

    public List<T> getHashed(List<T> data) {
        List<T> temp = new ArrayList<T>();
        int i = 0;
        while (i < data.size()) {
            T left = data.get(i);
            i++;

            T right = null;
            if (i != data.size()) {
                right = data.get(i);
            }

/* Code to demonstrate the use of Java 8 Lambda expression */
            Hash<T> hash = (l, r) -> {
                if (l instanceof Integer && r instanceof Integer)
                    return (T) (Integer) ((Integer) l + (Integer) r);
                else return null;
            };

            T hashed = hashing(left, right, hash);
            temp.add(hashed);
            i++;
        }
        return temp;
    }

    public T hashing(T left, T right, Hash<T> hash) {
        return hash.getHash(left, right);
    }


    public static void main(String args[]) {
        int low = 1;
        int high = 100;
        List<Integer> seedList = new ArrayList<Integer>();

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            seedList.add(random.nextInt(high - low) + low);
        }

        System.out.print("Seed Data: ");
        seedList.forEach((val) -> System.out.print(val + ", "));
        System.out.println("");

        MerkelTree<Integer> merkleTree = new MerkelTree<Integer>(seedList);

        Integer merkleRoot = merkleTree.buildTree();
        System.out.println("Merkle Root is " + merkleRoot);
    }
}

interface Hash<T> {
    /* The implementation class will implement this method using Java 8 Lambda expression.
    * If we don't want to use Lambda expression we can convert this method to default method.
    * */
    T getHash(T left, T right);
}


