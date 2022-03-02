package Models

class Gasto {
    private var id: Int = 0
    private var date: String=""
    private var concept:String=""
    private var value: Int = 0




    constructor(id: Int,concept:String, date: String, value: Int) {
        this.id = id
        this.concept=concept
        this.date = date
        this.value = value
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
}
