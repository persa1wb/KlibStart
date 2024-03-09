
import kotlinx.browser.document
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
    val mything = CounterComponent.create()
    createRoot(container).render(mything)
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

