package paint;

public class PaintObject {

	@SuppressWarnings("unused")
	private int radius;
	private boolean drawing;

	public PaintObject(PaintSelectionIdentifier id) {
		switch (id) {
		case PAINT_THICKNESS_ONE -> this.radius = 1;
		case PAINT_THICKNESS_TWO -> this.radius = 2;
		case PAINT_THICKNESS_THREE -> this.radius = 3;
		case PAINT_THICKNESS_FOUR -> this.radius = 4;
		case FILLER -> this.radius = Integer.MAX_VALUE;
		default -> this.radius = 0;
		}
	}

	public int getRadius() {
		return this.radius;
	}

	// TODO: not efficient
	public void updateRadius(PaintSelectionIdentifier id) {
		this.radius = new PaintObject(id).radius;
	}
}
