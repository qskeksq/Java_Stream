import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda4 {
	
	static String[] memos = {
			"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
			"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?",
			"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.",
			"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains."
	};

	public static void main(String[] args) {
//		List<String[]> list = Stream.of(memos).map(s->s.split(" ")).collect(Collectors.toList());
		// flatmap 은 2차원 구조를 1차원 배열로 바꿔주는 일을 함. List<String[]>가 2차원 배열이니까
		//Stream<String[]>  // Stream<String>
//		Stream.of(list).flatMap(strings-> strings.stream()).forEach(System.out::println);
//		 잘 모르겠으면 Func 쳐 보면 안다.
			// 배열을 스트림으로 // 스트림 배열을 만들어주면 flatMap이 알아서 일렬화된 스트림으로 바꿔준다.
		Stream.of("to", "for", "et", "will").forEach(Lambda4::countString);
		System.out.println();
		Stream.of(1,2,3,4,5,6,7).forEach(Lambda4::countStringLength);
		System.out.println();
		countStringSeparateByRegEx("/[a-z]{7}/");
		System.out.println();
		countStringSeparateByRegEx("/[a-z]+..");
	}
	
	// 같은 문자 조사
	private static void countString(String param){
		long counts = Stream.of(memos).flatMap(strings->Arrays.stream(strings.split(" "))).map(s->s.toLowerCase()).filter(s->s.equals(param)).count();
		System.out.printf("%s:%d : ", param,counts);
	}
	
	// 길이 조사
	private static void countStringLength(int param){									// 모든 문자가 스스로의 길이 값으로 바뀌고  // 거기서 
		long counts = Stream.of(memos).flatMap(strings->Arrays.stream(strings.split(" "))).map(s->s.length()).filter(s->s == param).count();
		System.out.printf("%s:%d : ", param,counts);
	}
	
	// 정규표현식으로 조사
	private static void countStringSeparateByRegEx(String regex){									// 모든 문자가 스스로의 길이 값으로 바뀌고  // 거기서 
		Stream.of(memos).flatMap(strings->Arrays.stream(strings.split(regex))).map(s->s.length()).forEach(System.out::println);
	}
	
}
