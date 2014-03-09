package Java.problem424;

import java.util.List;

public interface ValueCell extends Cell{
	List<Integer> getPossibleValues();

	void removeValue(int j);
}
