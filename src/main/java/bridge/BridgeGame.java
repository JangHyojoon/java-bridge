package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> upMapper;
    private final List<String> downMapper;
    private int movingCount;
    public BridgeGame() {
        upMapper = new LinkedList<>();
        downMapper = new LinkedList<>();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(Mark mark) {
        if (mark.getDirection().equals(BridgeDirection.UP.getDirection())) {
            return addUpMapper(mark);
        }
        return addDownMapper(mark);
    }

    private List<List<String>> addUpMapper(Mark mark) {
        upMapper.add(mark.getMark());
        downMapper.add(" ");
        return List.of(upMapper, downMapper);
    }

    private List<List<String>> addDownMapper(Mark mark) {
        downMapper.add(mark.toString());
        upMapper.add(" ");
        return List.of(upMapper, downMapper);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upMapper.clear();
        downMapper.clear();
        movingCount = 0;
    }

    public int countMoving() {
        return movingCount++;
    }
}
