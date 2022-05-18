#WYSIWYG Editor for LaTeX tables and PGF/TikZ pictures



###Kotlin-based DSL for LaTeX Tables example
```kotlin
val table1 = table(
        allignment {
            here()
        },
        LeftCentering(),
        TableCaption("Caption text"),
        TabularEnvironment()
    ) {

    }

    println(table1.toTex())
```
###Kotlin-based DSL for PGF/TikZ Pictures example
```kotlin
val tikz1 = tikz {
    params {

    }
    colorlet {

    }
    colorlet {

    }
}

print(tikz1.toTex())
```