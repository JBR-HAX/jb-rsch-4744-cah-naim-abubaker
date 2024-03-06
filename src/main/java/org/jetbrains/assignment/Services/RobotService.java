@Service
public class RobotService {

    public List<Location> calculateCoordinates(List<Movement> movements) {
        List<Location> coordinates = new ArrayList<>();
        int x = 0;
        int y = 0;

        for (Movement movement : movements) {
            switch (movement.getDirection()) {
                case "NORTH":
                    y += movement.getSteps();
                    break;
                case "EAST":
                    x += movement.getSteps();
                    break;
                case "SOUTH":
                    y -= movement.getSteps();
                    break;
                case "WEST":
                    x -= movement.getSteps();
                    break;
            }
            coordinates.add(new Location(x, y));
        }

        return coordinates;
    }

    public List<Movement> generateMoves(List<Location> locations) {
        List<Movement> moves = new ArrayList<>();

        for (int i = 1; i < locations.size(); i++) {
            int deltaX = locations.get(i).getX() - locations.get(i - 1).getX();
            int deltaY = locations.get(i).getY() - locations.get(i - 1).getY();

            if (deltaX > 0) {
                moves.add(new Movement("EAST", deltaX));
            } else if (deltaX < 0) {
                moves.add(new Movement("WEST", Math.abs(deltaX)));
            }

            if (deltaY > 0) {
                moves.add(new Movement("NORTH", deltaY));
            } else if (deltaY < 0) {
                moves.add(new Movement("SOUTH", Math.abs(deltaY)));
            }
        }

        return moves;
    }
}
