package components

import model.AudienceRecord
import model.ContextRecord
import model.DefinitionRecord
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.em

interface DictionaryEntryAudienceContext {
    var audience: AudienceRecord
    var context: ContextRecord
}

external interface DictionaryEntryProps : Props {
    var definition: DefinitionRecord
    var audienceContexts: Array<DictionaryEntryAudienceContext>
}

val DictionaryEntry = FC<DictionaryEntryProps> {
    div {
        +"${it.definition}"
        it.audienceContexts.map { ac ->
            div {
                em {
                    +"[${ac.audience.name} | ${ac.context.name}]"
                }
            }
        }
    }
}
