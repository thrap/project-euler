function KakuroCtrl($scope) {
    updatePuzzle("6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X");

    $scope.updateBoard = function() {
        updatePuzzle($scope.input);
    };

    function Cell(cellText) {
        if (cellText === 'X')
            this.class = 'grey';
        else if (cellText === 'O')
            this.class = 'white empty';
        else if (/[A-Z]$/.test(cellText)) {
            this.class = 'white';
            this.content = cellText;
        } else {
            this.class ='sum';
            var self = this;
            var sum = cellText.replace('(','').replace(')','');
            if (sum.indexOf(',') !== -1) {
                var split = sum.split(',');
                self.upperText = split[0].substr(1);
                self.lowerText = split[0].substr(1);
            } else {
                if (sum[0] === 'h') {
                    self.upperText = sum.substr(1);
                } else {
                    self.lowerText = sum.substr(1);
                }
            }
        }
    }

    function updatePuzzle(input) {
        var split = input.split(',');

        $scope.rows = [];
        var length = parseInt(split[0]);
        var row = [];
        for (var i = 1; i<split.length; i++) {
            var cellText = split[i];
            if (cellText[0] === '(' && cellText[cellText.length-1] !== ')') {
                cellText += ','+split[++i];
            }

            row.push(new Cell(cellText));
            if (row.length === length) {
                $scope.rows.push(row);
                row = [];
            }
        }
    }
}