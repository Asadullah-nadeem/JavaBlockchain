package block;


import java.security.MessageDigest;

public class Block {
    private String data;
    private String previousHash;
    private String hash;
    private long timestamp;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.hash = calculateHash(); 
    }

    public String calculateHash() {
        String input = previousHash + timestamp + data;
        return applySha256(input);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); 
        while (!hash.substring(0, difficulty).equals(target)) {
            timestamp = System.currentTimeMillis();
            hash = calculateHash();
        }
        System.out.println("Block Mined: " + hash);
    }

    public String getHash() {
        return hash;
    }

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}