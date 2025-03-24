import os
import sys

def create_boj_directory_with_java(name):
    # 하위 디렉토리 경로 생성
    dir_path = os.path.join("src", f"boj{name}")

    try:
        # 디렉토리 생성
        os.makedirs(dir_path, exist_ok=True)
        print(f"✅ 디렉토리 생성됨: {dir_path}")

        # Main.java 파일 경로
        java_file_path = os.path.join(dir_path, "Main.java")

        # Main.java 기본 코드
        java_code = f"""package boj{name};

public class Main {{
    public static void main(String[] args) {{
        // 코드 작성
    }}
}}
"""

        # 파일이 없으면 생성
        if not os.path.exists(java_file_path):
            with open(java_file_path, "w", encoding="utf-8") as f:
                f.write(java_code)
            print(f"✅ 파일 생성됨: {java_file_path}")
        else:
            print(f"⚠️ 파일이 이미 존재합니다: {java_file_path}")

    except Exception as e:
        print(f"❌ 디렉토리 또는 파일 생성 실패: {e}")

if __name__ == "__main__":
    # 매개변수 확인
    if len(sys.argv) < 2:
        print("⚠️ 사용법: python script.py [문자열]")
        sys.exit(1)

    # 첫 번째 매개변수를 받아 디렉토리 및 파일 생성
    create_boj_directory_with_java(sys.argv[1])
