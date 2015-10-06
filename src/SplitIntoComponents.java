import java.util.NoSuchElementException;

public class SplitIntoComponents {
	private int[] sequenceComponents;
	final int minCompoment = 1;
	int inpuntNumber;
	int cntCompoments;

	public SplitIntoComponents(int inpuntNumber, int cntCompoments) {
		if (inpuntNumber > 150 || cntCompoments > 150 || cntCompoments > inpuntNumber || cntCompoments <= 0
				|| inpuntNumber <= 0) {
			throw new IllegalArgumentException("Вы указали неверные значения!");
		}
		this.inpuntNumber = inpuntNumber;
		this.cntCompoments = cntCompoments;
		sequenceComponents = new int[cntCompoments];
		createNewSequence(0, inpuntNumber - cntCompoments, inpuntNumber);
	}

	private void createNewSequence(int startIndex, int additionalElement, int max) {
		for (int i = startIndex; i < sequenceComponents.length; ++i) {
			int currentAdditionalElement = Math.min(additionalElement, max - minCompoment);
			sequenceComponents[i] = minCompoment + currentAdditionalElement;
			additionalElement -= currentAdditionalElement;
		}
	}

	public boolean hasNext() {
		return sequenceComponents != null;
	}

	public int[] nextComponents() {
		if (sequenceComponents == null)
			throw new NoSuchElementException();
		int[] result = sequenceComponents.clone();
		int indexToDecrease = sequenceComponents.length - 1;
		final int currentMin = sequenceComponents[indexToDecrease];
		int sum = 0;
		while (indexToDecrease >= 0 && sequenceComponents[indexToDecrease] - currentMin < 2)
			sum += sequenceComponents[indexToDecrease--] - minCompoment;
		if (indexToDecrease < 0)
			sequenceComponents = null;
		else
			createNewSequence(indexToDecrease + 1, sum + 1, --sequenceComponents[indexToDecrease]);
		return result;
	}

}