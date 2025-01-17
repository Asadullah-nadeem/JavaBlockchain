
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Blockchain {
    public static void main(String[] args) {
        ArrayList<block.Block> blockchain = new ArrayList<>();
        int difficulty = 4, numBlocks = 5;
        String previousHash = "0";

        try {
            for (int i = 1; i <= numBlocks; i++) {
                System.out.println("Mining block " + i + "...");
                block.Block newBlock = new block.Block("Block " + i + " Data", previousHash);
                newBlock.mineBlock(difficulty); 
                blockchain.add(newBlock);
                previousHash = newBlock.getHash(); 
            }
        } catch (Exception e) {
            System.out.println("An error occurred while mining blocks: " + e.getMessage());
            e.printStackTrace();
        }
        // int difficulty = 4;

        // System.out.println("Mining block 1...");
        // Block block1 = new Block("Block 1 Data", "0");
        // block1.mineBlock(difficulty);
        // blockchain.add(block1);

        // System.out.println("Mining block 2...");
        // Block block2 = new Block("Block 2 Data", block1.getHash());
        // block2.mineBlock(difficulty);
        // blockchain.add(block2);

        // System.out.println("Mining block 3...");
        // Block block3 = new Block("Block 3 Data", block2.getHash());
        // block3.mineBlock(difficulty);
        // blockchain.add(block3);

     

        // Disffplay the blockchain
        // for (Block block : blockchain) {
        // System.out.println("Block Hash: " + block.getHash());
        // }
//         System.out.println("\nBlockchain:");
//         try (FileWriter myWriter = new FileWriter("crypto.txt", true)) { // Append mode
//             for (Block block : blockchain) {
//                 String hash = block.getHash();
//                 if (hash == null || hash.isEmpty()) {
//                     System.out.println("Error: Block hash is null or empty for a block!");
//                 } else {
//                     System.out.println("Block Hash: " + hash);
//                     myWriter.write(hash + "\n"); // Append each hash on a new line
//                 }
//             }
//             myWriter.flush(); // Ensure data is written to file
//             System.out.println("Successfully wrote hashes to the file.");
//         } catch (IOException e) {
//             System.out.println("An error occurred while writing to the file.");
//             e.printStackTrace();
//         }
//     }
// }
 System.out.println("\nBlockchain:");
        try (FileWriter myWriter = new FileWriter("src/crypto.txt", true)) { // Append mode
            for (block.Block block : blockchain) {
                String hash = block.getHash();
                if (hash == null || hash.isEmpty()) {
                    System.out.println("Error: Block hash is null or empty for a block!");
                } else {
                    System.out.println("Block Hash: " + hash);
                    myWriter.write(hash + "\n"); // Append each hash on a new line
                }
            }
            myWriter.flush(); // Ensure data is written to file
            System.out.println("Successfully wrote hashes to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
