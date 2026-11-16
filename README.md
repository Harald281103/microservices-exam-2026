Starting the program:
"mvn clean package -DskipsTests"
"docker compose up -d --build"

open: http://localhost:8080/swagger-ui/index.html#/

then:
execute start
you will then see the item that you shall bid in its response body

go to bid
make a bid (you only need to write the number, not the currency)
execute bid

when you want to go to next bidding round:
execute nextRound

go back to make a bid and place a new bid

after 5 rounds the game finishes

then you can go to seeTop10
execute and see your score

then you can execute stop
and finally, write :
"docker compose down" in the terminal