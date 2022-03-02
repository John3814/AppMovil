package Models

class CuentasPagar {
    private var id: Int = 0
    private var date: String=""
    private var concept:String=""
    private var value: Int = 0
    private var dateLim: String = ""
    private var name: String=""
    private var nameID: Int=0
    private var phone: Int=0

    constructor(id: Int, date: String, concept: String, value: Int, dateLim: String, name: String, nameID: Int, phone: Int) {
        this.id = id
        this.date = date
        this.concept = concept
        this.value = value
        this.dateLim = dateLim
        this.name = name
        this.nameID = nameID
        this.phone = phone
    }
    fun getId(): Int {
        return id;
    }

    fun getValue(): Int {
        return value;
    }

    fun getDate(): String {
        return date;
    }

    fun getConcept(): String {
        return concept;
    }

    fun getDateLim(): String {
        return dateLim;
    }

    fun getName(): String {
        return name;
    }

    fun getPhone(): Int {
        return phone;
    }

    fun getNameID(): Int {
        return nameID;
    }


}