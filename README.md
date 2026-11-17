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

about the game:
this is a small auction game.
the player can bid on items, and after each bidding round, the winner gets the items score saved to their this-game's score
they can then check their score on the leaderboard
(currently its just one player, i didnt add an ai opponent, i will explain why in the report)

this game have 4 micro services
game: controlls the flow of the game, starting and stopping the game, and managing rounds. it also has all the endpoints needed to play the game
auction house: manages each round of bidding, primarily validating bids, placing bids and declearing the winner
player: handles the players and their money
score: handles the score added to the winning player after a bidding round. score also handles the leaderboard

in this game, all services uses rest calls to request or send information to eachother, like how auctionhouse needs player to check how much money the player who
is currently bidding has.
score uses kafka, this alows the game to continue playing even if score is down
i think the idea is good, for the game to run it technically doesnt need score, which is why score i perfect to use kafka
the kafka connection is between score and auctionhouse btw

so when a round is done, the winner gets their score sendt from auction house to score, where the score will be saved in the database, while the game is still running
and playing the next round
