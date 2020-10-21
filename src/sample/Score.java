function reset(){
//moves ball back to original X cords
ballDX= ball.setLayout(ballyX);
//moves ball back to original Y  cords
ballDY= ball.setLayoutX(ballY);
//reset ball Speed
maxSpeed = 6;

}

if (ballY>=pane.gitMinWidth(+25)){
p2paddleDY +=1;
//Player 2 scores
reset();
}
if (ballY<=pane.gitMinWidth(+15)){
p1paddleDY +=1;
//player 1 scores
reset();
}
function render() {
  // draw P1paddleDY score
  drawScore(pane.width / 4, pain.height / 6, P1paddleDy.score);
  // draw P2paddleDY score
  drawScore(3 * canvas.width / 4, canvas.height / 6, P2paddleDy.score);
}
function drawScore(x, y, score) {
  ctx.fillStyle = '#fff';
  ctx.font = '35px sans-serif';

  // syntax --> fillText(text, x, y)
  ctx.fillText(score, x, y);
}
