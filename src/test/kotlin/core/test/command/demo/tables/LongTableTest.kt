package core.test.command.demo.tables

import org.junit.Test

class LongTableTest {

    val expectedTable = """
        \begin{longtable}{|c|c|c|c|}  
        \caption{A simple example of longtable}\\  
        \hline  
        \textbf{First heading} & \textbf{Second heading} & \textbf{Third heading} &  
        \textbf{Fourth heading} \\  
        \hline  
        \endfirsthead  
        \multicolumn{4}{c}%  
        {\tablename\ \thetable\ -- \textit{Continued from previous page}} \\  
        \hline  
        \textbf{First heading} & \textbf{Second heading} & \textbf{Third heading} &  
        \textbf{Fourth heading} \\  
        \hline  
        \endhead  
        \hline \multicolumn{4}{r}{\textit{Continued on next page}} \\  
        \endfoot  
        \hline  
        \endlastfoot  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        ab & bc & ac & da \\ ef & fg & gh & he \\ ij & jk & kl & lj \\ mn & no & op & po \\  
        \end{longtable}  
    """.trimIndent()

    @Test
    fun longTableTest() {

    }
}