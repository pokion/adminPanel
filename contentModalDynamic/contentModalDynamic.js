import { LightningElement, createElement, api } from 'lwc';
import contentArchived from 'custom/contentArchived';

export default class contentModalDynamic extends LightningElement{
	componentConstructor;
	@api
	actionName;

	connectedCallback(){
		this.loadComponent();
	}

	async loadComponent(){
		const ctor = await import('custom/contentArchived');
		this.componentConstructor = ctor.default;
	}

	get isModalVisible(){
		return this.componentConstructor;

	}

	dispatchCloseContentModalEvent() {
        this.dispatchEvent(new CustomEvent('closecontentmodaldynamic', {}));
    }

	handleClose(event) {
        this.dispatchCloseContentModalEvent();
    }

}