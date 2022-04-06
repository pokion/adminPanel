function Product(){

	this.connect = async function(path){
		try{
			const product = await fetch(`http:localhost:8080/${path}`);
			return Promise.resolve(product.json());
		}catch (e) {
			return Promise.reject(e);
		}
	}

	this.one = function(id, callback){
		this.connect(`product/${id}`)
			.then( product => {
				callback(product);
			} )
			.catch( err => {
				console.log(JSON.stringify(err));
			})
	}

	this.all = function(callback){
		this.connect('product')
			.then( product => {
				callback(product);
			})
			.catch( err => {
				console.log(JSON.stringify(err));
			})
	}
}