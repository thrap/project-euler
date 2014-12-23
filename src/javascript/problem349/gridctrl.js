function GridCtrl($scope, $interval) {
    console.log("Hei");
    var SIZE = 100;
    $scope.black = [];
    for (var i = 0; i<SIZE; i++) {
        var row = [];
        for (var j = 0; j<SIZE; j++) {
            row.push(false);
        }
        $scope.black.push(row);
    }

    console.log($scope.black);

    var Direction = {
        UP: [0,-1],
        LEFT: [-1,0],
        DOWN: [0,1],
        RIGHT: [1,0]
    }

    $scope.steps = 0;


    var Ant = function(x, y) {
        this.x = x;
        this.y = y;
        this.direction = Direction.UP;

        var self = this;
        this.move = function() {
            $scope.black[self.x][self.y] = !$scope.black[self.x][self.y];
            console.log(self.direction);

            if ($scope.black[self.x][self.y]) {
                if (self.direction == Direction.UP) {
                    self.direction = Direction.LEFT;
                } else if (self.direction == Direction.LEFT) {
                    self.direction = Direction.DOWN;
                } else if (self.direction == Direction.DOWN) {
                    self.direction = Direction.RIGHT;
                } else if (self.direction == Direction.RIGHT) {
                    self.direction = Direction.UP;
                }
            } else {
                if (self.direction == Direction.UP) {
                    self.direction = Direction.RIGHT;
                } else if (self.direction == Direction.RIGHT) {
                    self.direction = Direction.DOWN;
                } else if (self.direction == Direction.DOWN) {
                    self.direction = Direction.LEFT;
                } else if (self.direction == Direction.LEFT) {
                    self.direction = Direction.UP;
                }
            }
            self.x += self.direction[0];
            self.y += self.direction[1];

            $scope.steps++;
        }
    }

    var ant = new Ant(SIZE/2, SIZE/2);


    $interval(ant.move, 1);

}
