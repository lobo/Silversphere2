package backend;

public interface ContentOperations {

	/**
	 * Removes content from given Cell
	 * 
	 * @return True if removal is successful, False if not
	 */
	public boolean removeContent();

	/**
	 * Returns Content from given Cell
	 * 
	 * @return Content
	 */
	public Content getContent();
}