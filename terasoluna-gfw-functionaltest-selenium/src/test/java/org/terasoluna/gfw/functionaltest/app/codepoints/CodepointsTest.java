package org.terasoluna.gfw.functionaltest.app.codepoints;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.terasoluna.gfw.common.codepoints.CodePoints;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Katakana;

public class CodepointsTest {

	@Test
	public void codePointsTest_01() {
		CodePoints codepoints1 = CodePoints.of(JIS_X_0208_Katakana.class);
		CodePoints codepoints2 = CodePoints.of(JIS_X_0208_Katakana.class);
		
		assertThat(codepoints1, is(codepoints2));
		assertThat(codepoints1.containsAll("カナ"), is(true));
	}

	@Test
	public void codePointsTest_02() {
		CodePoints codepoints = new JIS_X_0208_Katakana();
		
		assertThat(codepoints.containsAll("カナ"), is(true));
	}

	@Test
	public void codePointsTest_03() {
		CodePoints codepoints = new CodePoints(0x0061, 0x0062);
		
		assertThat(codepoints.containsAll("ab"), is(true));
	}

	@Test
	public void codePointsTest_04() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(0x0061);
		set.add(0x0062);
		CodePoints codepoints = new CodePoints(set);
		
		assertThat(codepoints.containsAll("ab"), is(true));
	}
	
	@Test
	public void codePointsTest_05() {
		CodePoints codepoints = new CodePoints("ab");
		
		assertThat(codepoints.containsAll("ab"), is(true));
	}
	
	@Test
	public void codePointsTest_06() {
		CodePoints codepoints = new CodePoints("a", "b");
		
		assertThat(codepoints.containsAll("ab"), is(true));
	}
	
	@Test
	public void codePointsTest_07() {
		CodePoints abCp = new CodePoints(0x0061 /* a */, 0x0062 /* b */);
		CodePoints cdCp = new CodePoints(0x0063 /* c */, 0x0064 /* d */);

		CodePoints abcdCp = abCp.union(cdCp);
		
		assertThat(abcdCp.containsAll("abcd"), is(true));
	}
	
	@Test
	public void codePointsTest_08() {
		CodePoints abcdCp = new CodePoints(0x0061 /* a */, 0x0062 /* b */,
				0x0063 /* c */, 0x0064 /* d */);
		CodePoints cdCp = new CodePoints(0x0063 /* c */, 0x0064 /* d */);

		CodePoints abCp = abcdCp.subtract(cdCp);

		assertThat(abCp.containsAll("ab"), is(true));
	}

	@Test
	public void codePointsTest_09() {
		CodePoints abcdCp = new CodePoints(0x0061 /* a */, 0x0062 /* b */,
		        0x0063 /* c */, 0x0064 /* d */);
		CodePoints cdeCp = new CodePoints(0x0063 /* c */, 0x0064 /* d */, 0x0064 /* e */);

		CodePoints cdCp = abcdCp.intersect(cdeCp);
		
		assertThat(cdCp.containsAll("cd"), is(true));
	}

	@Test
	public void codePointsTest_10_11_12() {
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);

		assertThat(jisX208KanaCp.containsAll("カ"), is(true));
		assertThat(jisX208KanaCp.containsAll("カナ"), is(true));
		assertThat(jisX208KanaCp.containsAll("カナa"), is(false));
	}

	@Test
	public void codePointsTest_13_14_15_16() {
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);

		assertThat(jisX208KanaCp.firstExcludedCodePoint("カナ"), is(CodePoints.NOT_FOUND));
		assertThat(jisX208KanaCp.firstExcludedCodePoint("aカナ"), is(0x0061));
		assertThat(jisX208KanaCp.firstExcludedCodePoint("カaナ"), is(0x0061));
		assertThat(jisX208KanaCp.firstExcludedCodePoint("カナa"), is(0x0061));
	}

	@Test
	public void codePointsTest_17_18_19() {
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);

		Set<Integer> result;
		result = jisX208KanaCp.allExcludedCodePoints("カナ");
		assertThat(result.size(), is(0));
		result = jisX208KanaCp.allExcludedCodePoints("カナa");  // [0x0061 (a)]
		assertThat(result.size(), is(1));
		assertThat(result.contains(0x0061), is(true));
		result = jisX208KanaCp.allExcludedCodePoints("カaナb"); // [0x0061 (a), 0x0062 (b)]
		assertThat(result.size(), is(2));
		assertThat(result.contains(0x0061), is(true));
		assertThat(result.contains(0x0062), is(true));
	}

}
