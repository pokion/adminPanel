function Cart(){

	this.connect = async function(path, opt){
		try{
			const cart = await fetch(`http:localhost:8080/${path}`, opt)
			return Promise.resolve(cart.json())
		}catch (e){
			return Promise.reject(e);
		}
	}

	this.send = function(data, callback){
		this.connect('cart', {
			headers: {
				'Content-Type': 'application/json',
				'Authorization': cookie.getCookie('token')
			},
			method: 'POST',
			body: JSON.stringify(data)
		}).then( res => {
			callback(res)
		}).catch( res => {
			console.log(res)
		})
	}

	this.getByOrderID = function(id,callback){
		this.connect('cart/'+id, {
			headers: {
				'Content-Type': 'application/json',
				'Authorization': cookie.getCookie('token')
			},
			method: 'GET'
		}).then( res => {
			callback(res)
		}).catch( res => {
			console.log(res)
		})
	}

	this.get = function(data, callback){
		this.connect('cart', {
			headers: {
				'Content-Type': 'application/json',
				'Authorization': cookie.getCookie('token')
			},
			method: 'GET'
		}).then( res => {
			callback(res)
		}).catch( res => {
			console.log(res)
		})
	}
}