@RestController
public class RobotController {

    @Autowired
    private RobotService robotService;

    @PostMapping("/locations")
    public List<Location> processMovements(@RequestBody List<Movement> movements) {
        return robotService.calculateCoordinates(movements);
    }

    @PostMapping("/moves")
    public List<Movement> generateRobotMoves(@RequestBody List<Location> locations) {
        return robotService.generateMoves(locations);
    }
}
