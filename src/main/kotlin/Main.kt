import components.DictionaryListing
import kotlinx.browser.document
import model.TermRecord
import model.TermRecordRun
import model.getUsageRecords
import react.FC
import react.Props
import react.dom.client.createRoot
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.useState
import react.*

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)
    //val mything = CounterComponent.create()
    val mything = PhonyComponent.create()
    createRoot(container).render(mything)
}

val PhonyComponent = FC<Props> {
    DictionaryListing {
        term = TermRecordRun
        usages = getUsageRecords(TermRecordRun)
    }
}

val CounterComponent = FC<Props> {
    var count by useState(0)

    val incrementCount = {
        count += 1
    }

    div {
        +"Count: $count"
        button {
            +"Click me"
            onClick = { incrementCount() }
        }
    }
}
