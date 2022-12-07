sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageBox",
	"sap/m/MessageToast",
	"tom/util/service"
], function(Controller, MessageBox, MessageToast, Service){
	return Controller.extend("tom.controller.Main", {
		onInit:function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"vendor": {
					        "companyName": "EY",
					        "contactPerson": "Santosh",
					        "firstName": "Hooper",
					        "lastName": "Konaraddi",
					        "website": "www.ey.com",
					        "email": "ey@gmail.com",
					        "status": "married",
					        "regDate": new Date()
        				  },
        		"vendorTab" : []		  
			});
			this.getView().setModel(oModel);
			this.fetchAndLoadData();
		},
		
		fetchAndLoadData: function(){
			//Step - 1: get the local model
			var oModel = this.getView().getModel();
			
			// Step - 2: call the micro service to load the vendor data
			Service.callService("/vendor", "GET")
			.then(function(data){
				oModel.setProperty("/vendorTab", data);
				MessageToast.show(data.length.toString() + " Records were loaded");
			})
			.catch(function(){
				MessageBox.error("Data Fetch Failed");
			})
							
			
			
		},
		
		onDelete: function(){
			
			//note : plain rest service is biult till class 6, we will create OData with rest service later
			//"Step - 1 : Get teh table object"
			
			//"Strp - 2 : Get all the selected Record fromt he table"
			
			//"Step - 3 : Call Service API to fire DELETE - Loop	
			
			//"Step - 4 : Handle Respinse"
		},
		
		onSave: function(){
			//MessageBox.confirm("Your Vendor is now Saved !!");
			//Step - 1 : Access the data from the model; whatever the changes that user did
			// will reflect inside model from UI
			var oModel = this.getView().getModel();
			var payload = oModel.getProperty("/vendor");
			var that = this  
			
			//Step - 2 : Use the service class object to POST the Data
			Service.callService("/vendor", "POST", payload)
			.then(function(){
				MessageBox.confirm("Your vendor is now saved");
				that.fetchAndLoadData();
			})
			.catch(function(){
				MessageBox.confirm("The vendor creation failed");
			})
			
			//Step - 3 : We will display the message to user
			
		}
		
	});
	
});