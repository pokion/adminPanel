function Auth(){

	this.connect = async function(path, opt){
		let options = opt || {};
		try{
			const auth = await fetch(`http:localhost:8080/${path}`, options);
			return Promise.resolve(auth.json());
		}catch (e){
			return Promise.reject(e);
		}
	}

	this.authenticate = function(user, callback){
		this.connect(`authenticate`, {
			headers: {
		      'Content-Type': 'application/json'
		    },
		    method: 'POST',
		    body: JSON.stringify(user)
		}).then( token => {
			callback(token)
		}).catch( err =>{
			console.log(JSON.stringify(err))
		})
	}

	this.removeToken = function(token, callback){
		this.connect('authenticate', {
			headers: {
		      'Content-Type': 'application/json',
		      'Authorization': token
		    },
		    method: 'DELETE'
		}).then(res => {
			callback(res)
		}).catch(err => {
			callback(err)
		})
	}

}