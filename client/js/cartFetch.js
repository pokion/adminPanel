function Cart(){
	this.connect = async function(path, opt){
		let options = opt || {};
		try{
			const cart = await fetch(`http:localhost:8080/${path}`, options);
			return Promise.resolve(cart.json());
		}catch (e){
			return Promise.reject(e);
		}
	}

	this.cart = function(token, callback){
		this.connect(`cart`, {
			headers: {
				'Content-Type': 'application/json',
				'Authorization': token
			},
			method: 'GET'
		}).then( carts => {
			callback(carts)
		}).catch( err =>{
			console.log(JSON.stringify(err))
		})
	}
}