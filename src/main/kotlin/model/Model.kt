package model

data class TermRecord (var term: String )

data class DefinitionRecord (var partOfSpeech: String,var definition: String)


data class AudienceRecord (var name: String)

data class ContextRecord (var name: String)
// Not all terms should need a specific context, so a general context is available.
var ContextRecordGeneral = ContextRecord ("general")

data class UsageRecord (
    var term: TermRecord,
    var audience: AudienceRecord,
    var context: ContextRecord,
    var definition: DefinitionRecord)

var TermRecordRun = TermRecord ("run")

var ContextRecordTacoTuesday = ContextRecord ("taco tuesday")

var AudienceRecordDevelopers = AudienceRecord ("developers")
var AudienceRecordGymTeachers = AudienceRecord ("gym teachers")

var DefinitionRecordRunWithLegs = DefinitionRecord (
     "verb",
    "to move your legs quickly in sync for the purpose of ambulating faster than typical"
)
var DefinitionRecordRunOfAnApplication = DefinitionRecord (
    "noun",  
    "the completed execution of an software application; it's output and/or it's results")
var DefinitionRecordRunAnApplication = DefinitionRecord (
    "verb",
    "to start or initiate a software application"
)

fun getUsageRecords(): Array<UsageRecord> {
    return arrayOf(
        UsageRecord (
            TermRecordRun,
            AudienceRecordDevelopers,
            ContextRecordGeneral,
            DefinitionRecordRunAnApplication,
        ),
        UsageRecord (
            TermRecordRun,
            AudienceRecordDevelopers,
             ContextRecordGeneral,
            DefinitionRecordRunOfAnApplication
    ),
        UsageRecord (
            TermRecordRun,
            AudienceRecordDevelopers,
             ContextRecordTacoTuesday,
            DefinitionRecordRunWithLegs
        ),
        UsageRecord (
            TermRecordRun,
            AudienceRecordGymTeachers,
             ContextRecordGeneral,
            DefinitionRecordRunWithLegs
    )
    )
}

fun getUsageRecords(term: TermRecord): Array<UsageRecord> {
    return getUsageRecords().filter {
        it.term == term
    }.toTypedArray()
}