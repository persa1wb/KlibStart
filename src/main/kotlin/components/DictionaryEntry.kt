package components

import model.AudienceRecord
import model.ContextRecord
import model.DefinitionRecord
import react.FC
import react.Props
import react.dom.html.ReactHTML

interface DictionaryEntryAudienceContext {
    var audience: AudienceRecord
    var context: ContextRecord
}

interface DictionaryEntryProps : Props {
    var definition: DefinitionRecord
    var audienceContexts: Array<DictionaryEntryAudienceContext>
}

val DictionaryEntry = FC<DictionaryEntryProps> {
    ReactHTML.div {
        +"${it.definition}"
        it.audienceContexts.map { ac ->
            ReactHTML.div {
                ReactHTML.em {
                    +"[${ac.audience.name} | ${ac.context.name}]"
                }
            }
        }
    }
}