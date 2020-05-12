import json
import pprint

from websocket import create_connection

path="streaming"
url = "wss://api.telos.spectrumeos.io/"+path

data = {"account":"eosio"}

messageBody ={
    "apikey":"test-api-key",
              "event":"subscribe",
               "type":"get_transaction",
              "data": data
              }
ws = create_connection(url)
messageJson = json.dumps(messageBody)
ws.send(messageJson)

while True:
    pprint.pprint(json.loads(ws.recv()))
ws.close()
