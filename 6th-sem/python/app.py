from flask import Flask,redirect,url_for,request,render_template
#from pymongo import MongoClient
		
app = Flask(__name__)
		 
@app.route('/hello')
def hello():
    	return 'Hello, Flask!'

@app.route('/')
def index():
    	return render_template('login.html')

@app.route('/signup', methods=['GET','POST'])
def signup():
    if request.method == 'POST':
    	email=request.form['email']

		

    			# email = request.form['email']
				# password = request.form['password']
				# password1 = request.form['password1']

				# if password == password1:
    			
				# else:
    			# 		flash("Password Mismatch")
				# 		return redirect("/signup")
if __name__ == '__main__':
		app.run(debug=True)