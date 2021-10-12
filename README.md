## Pacman - team 1

by Jayson Hurst, ..., ..., Liam DeVoe

![imag](https://github.com/cmsc389T-fall21/team1/blob/main/Projects/P2/Capture.PNG)

### Running

to run:

```sh
./runtest
```

### Functions

* ghost move
  * pick the first valid move and move to it
* map get loc
  * just return `field.get(loc)`
* pacman get valid moves
  * check the four locations in cardinal directions and add them to the return list if they aren't a wall

### Tests

* ghost move
  * add a ghost to the frame next to two walls, make sure it moved to one of the two remaining locations without walls
* map get loc
  * add ghosts and pacman to the map and make sure retrieving them returns the location where we put them
* ghost in range
  * make sure no ghost is in range when no ghosts are on the board. Then make sure a ghost is in range only when it's one tile away from pacman
