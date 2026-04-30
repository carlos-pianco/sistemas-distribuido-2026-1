from flask import Flask, render_template
import requests

app = Flask(__name__)

API = "http://localhost:3333"

@app.route("/")
def dashboard():
    res = requests.get(API + "/products").json()
    produtos = res.get("products", [])
    pedidos = requests.get(API + "/orders").json()

    return render_template("index.html", produtos=produtos, pedidos=pedidos)

if __name__ == "__main__":
    app.run(debug=True)