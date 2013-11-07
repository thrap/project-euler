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
        } else if (/[1-9]$/.test(cellText)) {
            this.class = 'white';
            this.content = cellText;
        } else if (/\(h[A-Z0-9]+\)$/.test(cellText)) {
            this.class = 'sum';
            this.upperText = cellText.replace(/\(|\)|h|v/g,'');
        } else if (/\(v[A-Z0-9]+\)$/.test(cellText)) {
            this.class = 'sum';
            this.lowerText = cellText.replace(/\(|\)|h|v/g,'');
        } else {
            this.class ='sum';
            var sums = cellText.match(/[A-Z0-9]+/g);
            console.log(sums);
            this.upperText = sums[0];
            this.lowerText = sums[1];
        }
    }

    function updatePuzzle(input) {
        var nodes = input.match(/\(.*?\)|[A-Z0-9]/g);

        $scope.rows = [];
        var length = parseInt(nodes[0]);
        var row = [];
        for (var i = 1; i<nodes.length; i++) {
            row.push(new Cell(nodes[i]));
            if (row.length === length) {
                $scope.rows.push(row);
                row = [];
            }
        }
    }
}