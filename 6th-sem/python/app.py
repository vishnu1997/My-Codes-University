from flask import Flask,redirect,url_for,request,render_template
#from pymongo import MongoClient
		
app = Flask(__name__)
		
@app.route('/')
def index():
	return 'Hello, Flask!'

@app.route('/page')
def page():
	return render_template('/Vishnu_119014025/index.html')	

if __name__ == '__main__':
	app.run(debug=True)