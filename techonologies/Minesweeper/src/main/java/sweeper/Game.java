package sweeper;

public class Game {
    private final Bomb bomb;
    private final Flag flag;
    private GameState state;

    public Game(int cols, int rows,  int totalBombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(totalBombs);
        flag = new Flag();
    }

    public GameState getState() {
        return state;
    }

    public Box getBox(Coord coord) {
        if (flag.get(coord) == Box.OPENED) {
            return bomb.get(coord);
        } else {
            return flag.get(coord);
        }
    }

    public void start() {
       bomb.start();
       flag.start();
       state = GameState.PLAYED;
    }


    public void pressLeftButton(Coord coord) {
        if (state != GameState.PLAYED) {
            return;
        }
        openBox(coord);
        checkWinner();
    }

    public void pressRightButton(Coord coord) {
        if (state != GameState.PLAYED) {
            return;
        }
        flag.toggleFlagedBox(coord);
    }

    private void checkWinner() {
        if (state == GameState.PLAYED && flag.getCountOfClosedBoxes() == bomb.getTotalBombs()) {
            state = GameState.WINNER;
        }
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED -> {
               setOpenedToClosedBoxesAroundNumber(coord);
            }
            case FLAGED -> {
            }
            case CLOSED -> {
                switch (bomb.get(coord)) {
                    case ZERO -> {
                        openBoxesAround(coord);
                    }
                    case BOMB -> {
                        openBombs(coord);
                    }
                    default -> {
                        flag.setOpenedToBox(coord);
                    }
                }
            }
        }
    }

    private void openBombs(Coord bombed) {
        state = GameState.BOMBED;
        flag.setBombedToBox(bombed);

        for (Coord coord: Ranges.getAllCoords()) {
            if (bomb.get(coord) == Box.BOMB) {
                flag.setOpenedToClosedBombBox(coord);
            } else {
                flag.setNoBombToFlageSafeBox(coord);
            }
        }
    }

    private void openBoxesAround(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around: Ranges.getCoordsAround(coord)) {
            openBox(around);
        }
    }

    private void setOpenedToClosedBoxesAroundNumber(Coord coord) {
        if (bomb.get(coord) != Box.BOMB) {
            if (flag.getCountOfFlagedBoxesAround(coord) == bomb.get(coord).getNumber()) {
                for (Coord around: Ranges.getCoordsAround(coord)) {
                    if (flag.get(around) == Box.CLOSED) {
                        openBox(around);
                    }
                }
            }
        }
    }
}
