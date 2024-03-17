package components

import model.AudienceRecord
import model.ContextRecord
import model.DefinitionRecord
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.em
import react.dom.html.ReactHTML.strong

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
        strong {
            +"${it.definition.partOfSpeech}"
        }
        +" ${it.definition.definition}"
        it.audienceContexts.map { ac ->
            div {
                em {
                    +"[${ac.audience.name} | ${ac.context.name}]"
                }
            }
        }
    }
}
