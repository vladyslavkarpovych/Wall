import java.util.*;

public class Wall implements Structure, CompositeBlock {
    private List<Block> blocks;
    private final String color;
    private final String material;
    private int amountOfBlocks;

    public Wall(String color, String material) {
        this.blocks = new ArrayList<>();
        this.color = color;
        this.material = material;
        this.amountOfBlocks = 0;
    }

    @Override
    public Optional findBlockByColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is null!");
        }

        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block.getColor());
            }
        }
        return Optional.empty();

    }

    @Override
    public List findBlocksByMaterial(String material) {
        if (material == null) {
            throw new IllegalArgumentException("Material is null!");
        }

        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                return (List) block;
            }
        }
        return null;
    }

    @Override
    public int count() {
        for (int i = 0; i < blocks.size(); i++) {
            amountOfBlocks++;
        }
        return amountOfBlocks;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    public void addNode(Block block) {
        blocks.add(block);
    }
}